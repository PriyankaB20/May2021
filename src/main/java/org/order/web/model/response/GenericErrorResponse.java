package org.order.web.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GenericErrorResponse {
    private int code;
    private String message;
}
