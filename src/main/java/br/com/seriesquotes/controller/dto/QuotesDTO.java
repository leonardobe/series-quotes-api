package br.com.seriesquotes.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Quote request payload")
public record QuotesDTO(
        @Schema(example = "Grey's Anatomy") String seriesName,

        @Schema(example = "We are only people. We make mistakes.")
        String phrase,

        @Schema(example = "Meredith Grey") String characterName,

        @Schema(example = "https://image.url/poster.jpg") String poster) {}
