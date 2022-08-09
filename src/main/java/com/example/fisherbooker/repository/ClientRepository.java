package com.example.fisherbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	public List<Client> findAll();

	@Query("FROM Client WHERE account_id = ?1")
	public Client findByAccountId(Long accountId);

	@Query(value = "select a.email \r\n" + "from client c, account a, cottage_subscriptions cs\r\n"
			+ "where c.account_id = a.id and c.id = cs.client_id and cs.cottage_id = :cottageId",
			nativeQuery = true)
	public List<String> getEmails(@Param("cottageId") Long id);

}
