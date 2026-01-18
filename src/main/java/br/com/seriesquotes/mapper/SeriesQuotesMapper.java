package br.com.seriesquotes.mapper;

import br.com.seriesquotes.controller.dto.QuotesDTO;
import br.com.seriesquotes.domain.entity.Quote;

public class SeriesQuotesMapper {

    public static QuotesDTO getQuotesDTO(Quote quote) {
        return new QuotesDTO(quote.getSerieName(), quote.getPhrase(), quote.getCharacterName(), quote.getPoster());
    }
}
