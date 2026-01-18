package br.com.seriesquotes.repository;

import br.com.seriesquotes.domain.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SeriesQuotesRepository extends JpaRepository<Quote, Long> {
    @Query("SELECT q FROM Quote q order by function('RANDOM') LIMIT 1")
    Quote findRandomQuote();
}
