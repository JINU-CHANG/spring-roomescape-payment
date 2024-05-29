package roomescape.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.ResponseErrorHandler;
import roomescape.exception.customexception.RoomEscapeBusinessException;
import roomescape.exception.customexception.ThirdPartyAPIException;
import roomescape.exception.dto.ThirdPartyErrorResponse;

@Component
public class RestTemplateResponseExceptionHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) {
        try {
            return response.getStatusCode().is4xxClientError() ||
                    response.getStatusCode().is5xxServerError();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void handleError(ClientHttpResponse response) {
        try {
            if (response.getStatusCode().is4xxClientError()) {
                throw new RoomEscapeBusinessException(getResponseBody(response).message());
            }

            if (response.getStatusCode().is5xxServerError()) {
                throw new ThirdPartyAPIException(getResponseBody(response).message());
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private ThirdPartyErrorResponse getResponseBody(ClientHttpResponse response) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(
                    FileCopyUtils.copyToByteArray(response.getBody()),
                    ThirdPartyErrorResponse.class);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
