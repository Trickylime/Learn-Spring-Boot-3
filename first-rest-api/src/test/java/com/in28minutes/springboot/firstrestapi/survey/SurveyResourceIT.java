package com.in28minutes.springboot.firstrestapi.survey;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyResourceIT {

    @Autowired
    private TestRestTemplate template;
    private static String SPECIFIC_QUESTION_URL = "/surveys/Survey1/questions/question1";
    private static String SPECIFIC_SURVEY_URL = "/surveys/Survey1";
    private static String GENERIC_QUESTIONS_URL = "/surveys/Survey1/questions";

    //Basic SmFjazpQYXNzdzByZA==
    @Test
    void retrieveQuestionById_basicScenario() throws JSONException {

        HttpHeaders headers = createHttpContentTypeAndAuthorizationHeaders();

        HttpEntity<String> httpEntity = new HttpEntity<>(null, headers);

        ResponseEntity<String> responseEntity
                = template.exchange(SPECIFIC_QUESTION_URL, HttpMethod.GET, httpEntity, String.class);

//        ResponseEntity<String> responseEntity = template.getForEntity(SPECIFIC_QUESTION_URL, String.class);

        String expectedResponse =
                """
                {
                    "id":"Question1",
                    "description":"Most Popular Cloud Platform Today",
                    "correctAnswer":"AWS"
                }
                """;

        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));

        JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);
    }

    @Test
    void retrieveSurveyById_basicScenario() throws JSONException {

        HttpHeaders headers = createHttpContentTypeAndAuthorizationHeaders();

        HttpEntity<String> httpEntity = new HttpEntity<>(null, headers);

        ResponseEntity<String> responseEntity
                = template.exchange(SPECIFIC_SURVEY_URL, HttpMethod.GET, httpEntity, String.class);
        //ResponseEntity<String> responseEntity = template.getForEntity(SPECIFIC_SURVEY_URL, String.class);

        String expectedResponse =
                """
                {
                    "id": "Survey1",
                    "title": "My Favorite Survey",
                    "description": "Description of the Survey",
                    "questions": [
                        {
                            "id": "Question1"
                        },
                        {
                            "id": "Question2"
                        },
                        {
                            "id": "Question3"
                        }
                    ]
                }
                        """;

        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));

        JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);
    }




    @Test
    void addNewSurveyQuestions_basicScenario() {

        String requestBody =
            """
                {
                    "description": "Your Favourite Language",
                    "options": [
                        "Java",
                        "Python",
                        "JavaScript",
                        "Haskell"
                    ],
                    "correctAnswer": "Java"
                }
            """;

        HttpHeaders headers = createHttpContentTypeAndAuthorizationHeaders();

        HttpEntity<String> httpEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> responseEntity
                = template.exchange(GENERIC_QUESTIONS_URL, HttpMethod.POST, httpEntity, String.class);

        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        String locationHeader = responseEntity.getHeaders().get("Location").get(0);
        assertTrue(locationHeader.contains("/surveys/Survey1/questions/"));


        ResponseEntity<String> responseEntityDelete
                = template.exchange(locationHeader, HttpMethod.DELETE, httpEntity, String.class);
        assertTrue(responseEntityDelete.getStatusCode().is2xxSuccessful());
        //        template.delete(locationHeader); //delete the new created survey question
    }

    private HttpHeaders createHttpContentTypeAndAuthorizationHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json");
        headers.add("Authorization", "Basic " + performBasicAuthEncoding("jack", "Passw0rd"));
        return headers;
    }

    String performBasicAuthEncoding(String user, String password) {

        String combined = user + ":" + password;
        byte[] encodedBytes = Base64.getEncoder().encode(combined.getBytes());
        return new String(encodedBytes);
    }
}
