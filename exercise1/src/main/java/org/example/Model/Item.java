package org.example.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
    @JsonProperty("code")
    private String code;

    @JsonProperty("quantity")
    private int quantity;
}
