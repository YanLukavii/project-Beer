package ru.app.external_api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ExternalAPIClient {

    private static final String EXTERNAL_API_URL = "https://rskrf.ru/rest/1/search/barcode?barcode=4601501410631";

    private final RestTemplate restTemplate;

    public String fetchDataFromExternalAPI() {
        return restTemplate.getForObject(EXTERNAL_API_URL, String.class);
    }
}