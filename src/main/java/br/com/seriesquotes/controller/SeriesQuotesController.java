package br.com.seriesquotes.controller;

import br.com.seriesquotes.controller.dto.QuotesDTO;
import br.com.seriesquotes.service.SeriesQuotesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Quotes", description = "Endpoints for series quotes")
@RestController
@RequestMapping("/quotes")
public class SeriesQuotesController {

    @Autowired
    private SeriesQuotesService service;

    @Operation(summary = "Show a random quote", description = "Returns a random quote")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Quote found"),
        @ApiResponse(responseCode = "404", description = "Quote not found")
    })
    @GetMapping("/random")
    public QuotesDTO getRandomPhrase() {
        return service.getRamdomPhases();
    }

    @Operation(summary = "Find quote by ID", description = "Returns a quote based on its ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Quote found"),
        @ApiResponse(responseCode = "404", description = "Quote not found")
    })
    @GetMapping("/{id}")
    public QuotesDTO getQuote(@PathVariable Long id) {
        return service.findById(id);
    }

    @Operation(summary = "Show all quotes", description = "Returns all citations already registered")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Quote found"),
        @ApiResponse(responseCode = "404", description = "Quote not found")
    })
    @GetMapping("/all")
    public List<QuotesDTO> getAllQuotes() {
        return service.findAll();
    }

    @Operation(summary = "Create a new quote", description = "Creates a quote for a series character")
    @ApiResponse(responseCode = "201", description = "Quote created")
    @PostMapping()
    public ResponseEntity<QuotesDTO> addQuote(@RequestBody QuotesDTO dto) {
        QuotesDTO created = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Operation(summary = "Delete a quote by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Quote deleted"),
        @ApiResponse(responseCode = "404", description = "Quote not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<QuotesDTO> deleteQuote(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
