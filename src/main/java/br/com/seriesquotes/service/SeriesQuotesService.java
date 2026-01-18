package br.com.seriesquotes.service;

import br.com.seriesquotes.controller.dto.QuotesDTO;
import br.com.seriesquotes.domain.entity.Quote;
import br.com.seriesquotes.mapper.SeriesQuotesMapper;
import br.com.seriesquotes.repository.SeriesQuotesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesQuotesService {

    @Autowired
    private SeriesQuotesRepository repository;

    public QuotesDTO getRamdomPhases() {
        Quote quote = repository.findRandomQuote();
        return SeriesQuotesMapper.getQuotesDTO(quote);
    }

    public QuotesDTO create(QuotesDTO dto) {
        Quote quote = new Quote();

        quote.setSerieName(dto.seriesName());
        quote.setPhrase(dto.phrase());
        quote.setCharacterName(dto.characterName());
        quote.setPoster(dto.poster());

        Quote saved = repository.save(quote);

        return SeriesQuotesMapper.getQuotesDTO(saved);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public QuotesDTO findById(Long id) {
        Quote quote = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Quote not found"));

        return SeriesQuotesMapper.getQuotesDTO(quote);
    }

    public List<QuotesDTO> findAll() {
        List<Quote> quotes = repository.findAll();

        return quotes.stream()
                .map(SeriesQuotesMapper::getQuotesDTO).toList();
    }
}
