package org.abc.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueJpaRepo extends JpaRepository<ExchangeValue,Long> {

    ExchangeValue findByFromAndTo(String from,String to);
}
