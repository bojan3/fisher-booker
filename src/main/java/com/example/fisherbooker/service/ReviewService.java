package com.example.fisherbooker.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.fisherbooker.model.Account;
import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.AdventureReview;
import com.example.fisherbooker.model.Client;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageReview;
import com.example.fisherbooker.model.Review;
import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.ShipReview;
import com.example.fisherbooker.model.DTO.ApproveReviewDTO;
import com.example.fisherbooker.model.DTO.CreateReviewDTO;
import com.example.fisherbooker.model.EmailContexts.NewReviewEmailContext;
import com.example.fisherbooker.repository.AdventureRepository;
import com.example.fisherbooker.repository.ClientRepository;
import com.example.fisherbooker.repository.CottageRepository;
import com.example.fisherbooker.repository.ReviewRepository;
import com.example.fisherbooker.repository.SecureTokenRepository;
import com.example.fisherbooker.repository.ShipRepository;
import com.example.fisherbooker.security.auth.SecureToken;

@Service
public class ReviewService {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	private ReviewRepository<CottageReview> cottagereviewRepository;

	@Autowired
	private ReviewRepository<ShipReview> shipreviewRepository;

	@Autowired
	private ReviewRepository<AdventureReview> adventurereviewRepository;

	@Autowired
	private CottageRepository cottageRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ShipRepository shipRepository;

	@Autowired
	private AdventureRepository adventureRepository;

	@Value("${site.base.url.https}")
	private String baseURL;

	@Autowired
	private EmailService emailService;

	@Autowired
	private SecureTokenService secureTokenService;
	// sad dal treba naglasiti koji implementira ili ce sam da skonta

	@Autowired
	private SecureTokenRepository secureTokenRepository;

	@Autowired
	public ReviewService(ReviewRepository<CottageReview> cottagereviewrepository,
			ReviewRepository<ShipReview> shipreviewrepository,
			ReviewRepository<AdventureReview> adventurereviewrepository, CottageRepository cottageRepository,
			ClientRepository clientRepository, ShipRepository shipRepository, AdventureRepository adventureRepository) {
		this.adventurereviewRepository = adventurereviewrepository;
		this.cottagereviewRepository = cottagereviewrepository;
		this.shipreviewRepository = shipreviewrepository;
		this.cottageRepository = cottageRepository;
		this.clientRepository = clientRepository;
		this.shipRepository = shipRepository;
		this.adventureRepository = adventureRepository;
	}

	@Transactional
	public void createCottageReview(CreateReviewDTO createReviewDTO) throws OptimisticLockException {
		Client client = getClient();
		Cottage cottage = entityManager.find(Cottage.class, createReviewDTO.getReviewEntityId(),
				LockModeType.OPTIMISTIC_FORCE_INCREMENT);
		CottageReview cottageReview = new CottageReview(createReviewDTO, client, cottage);

		// calculate new average mark
		List<CottageReview> oldReviews = cottagereviewRepository
				.findAllCottagesByCottageId(createReviewDTO.getReviewEntityId());
		if (!oldReviews.isEmpty()) {

			Iterator<CottageReview> it = oldReviews.iterator();
			float sum = (float) cottageReview.getGrade();

			while (it.hasNext()) {
				sum += (float) it.next().getGrade();
			}
			cottage.setAverageMark(sum / (oldReviews.size() + 1));
			
		} else {
			cottage.setAverageMark(createReviewDTO.getGrade());
		}
		cottage.getCottageReviews().add(cottageReview);
		
		entityManager.persist(cottage);
	}

	private Client getClient() {
		String clinetName = SecurityContextHolder.getContext().getAuthentication().getName();
		return this.clientRepository.findByName(clinetName);
	}

	public Boolean deleteReview(Long review_id) {
		Boolean response = false;
		try {
			this.adventurereviewRepository.deleteById(review_id);
			response = true;

		}

		catch (Exception err) {
			System.out.print("not an adventure");
			System.out.println(err);
		}
		try {
			this.cottagereviewRepository.deleteById(review_id);
			response = true;

		} catch (Exception err) {
			System.out.print("not a cottage");
			System.out.println(err);
		}

		try {

			this.shipreviewRepository.deleteById(review_id);
			response = true;
		} catch (Exception e) {
			System.out.print("not ship");
			System.out.println(e);
		} finally {
			return response;
		}

	}
//
//	public List<Review> getAllByGrade() {
//		return this.rr.findByOrderByGrade();
//	}

	public void createShipReview(CreateReviewDTO createReviewDTO) {
		Ship ship = this.shipRepository.getOne(createReviewDTO.getReviewEntityId());
		Client client = getClient();
		ShipReview shipReview = new ShipReview(createReviewDTO, client, ship);
		this.shipreviewRepository.save(shipReview);
	}

	public void createAdventureReview(CreateReviewDTO createReviewDTO) {
		Adventure adventure = this.adventureRepository.getOne(createReviewDTO.getReviewEntityId());
		Client client = getClient();
		AdventureReview adventureReview = new AdventureReview(createReviewDTO, client, adventure);
		this.adventurereviewRepository.save(adventureReview);
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED) // ,
																												// rollbackFor
																												// =
																												// Throwable.class)
	public CottageReview getCottageReview(Long reviewID) throws Exception {
		CottageReview cr = this.cottagereviewRepository.findById(reviewID).get();
		cr.setApproved(true);
		this.cottagereviewRepository.save(cr);
		return cr;
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED) // ,
																												// rollbackFor
																												// =
																												// Throwable.class)
	public ShipReview getShipReview(Long reviewID) throws Exception {
		ShipReview shr = this.shipreviewRepository.findById(reviewID).get();
		shr.setApproved(true);
		this.shipreviewRepository.save(shr);
		return shr;
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED) // ,
																												// rollbackFor
																												// =
																												// Throwable.class)
	public AdventureReview getAdventureReview(Long reviewID) throws Exception {
		AdventureReview ar = this.adventurereviewRepository.findById(reviewID).get();
		ar.setApproved(true);
		this.adventurereviewRepository.save(ar);
		return ar;
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED) // ,
																												// rollbackFor
																												// =
																												// Throwable.class)
	public void publish(Long reviewID) {
		Account acc = new Account();
		try {
			AdventureReview ar = this.adventurereviewRepository.findById(reviewID).get();
			ar.setApproved(true);
			this.adventurereviewRepository.save(ar);
			acc = ar.getAdventure().getFishingInstructor().getAccount();
			this.sendNewReviewEmail(acc, ar);

		}

		catch (Exception err) {
			System.out.print("not a adventure");
			System.out.println(err);
		}
		try {
			CottageReview cr = this.cottagereviewRepository.findById(reviewID).get();
			cr.setApproved(true);
			this.cottagereviewRepository.save(cr);
			acc = cr.getCottage().getCottageOwner().getAccount();
			this.sendNewReviewEmail(acc, cr);

		} catch (Exception err) {
			System.out.print("not a cottage");
			System.out.println(err);
		}

		try {

			ShipReview shr = this.shipreviewRepository.findById(reviewID).get();
			shr.setApproved(true);
			this.shipreviewRepository.save(shr);
			acc = shr.getShip().getShipOwner().getAccount();
			this.sendNewReviewEmail(acc, shr);

		} catch (Exception e) {
			System.out.print("not ship");
			System.out.println(e);
		} finally {

		}

	}

	public void sendNewReviewEmail(Account account, Review review) {
		SecureToken secureToken = secureTokenService.createSecureToken();
		secureToken.setAccount(account);
		secureTokenRepository.save(secureToken);

		NewReviewEmailContext emailContext = new NewReviewEmailContext();
		emailContext.init(account, review);
		emailContext.setToken(secureToken.getToken());
		// emailContext.buildVerificationUrl("http://localhost:4200",
		// secureToken.getToken());
		try {
			emailService.sendMail(emailContext);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<ApproveReviewDTO> getAllUnpublished() {
		List<CottageReview> cottagereviews = this.cottagereviewRepository.findAllCottages();
		List<ShipReview> shipreviews = this.shipreviewRepository.findAllShips();
		List<AdventureReview> adventurereviews = this.adventurereviewRepository.findAllAdventures();

		List<ApproveReviewDTO> unapproved = new ArrayList<ApproveReviewDTO>();
		List<ApproveReviewDTO> unapproved1 = new ArrayList<ApproveReviewDTO>();
		List<ApproveReviewDTO> unapproved2 = new ArrayList<ApproveReviewDTO>();
		List<ApproveReviewDTO> unapproved3 = new ArrayList<ApproveReviewDTO>();

		for (CottageReview cr : cottagereviews) {
			if (cr.getApproved().equals(false))
				unapproved1.add(new ApproveReviewDTO(cr));
		}

		for (ShipReview shr : shipreviews) {
			if (shr.getApproved().equals(false))
				unapproved2.add(new ApproveReviewDTO(shr));
		}

		for (AdventureReview ar : adventurereviews) {
			if (ar.getApproved().equals(false))
				unapproved3.add(new ApproveReviewDTO(ar));
		}

		unapproved.addAll(unapproved1);
		unapproved.addAll(unapproved2);
		unapproved.addAll(unapproved3);
		return unapproved;
	}

}
