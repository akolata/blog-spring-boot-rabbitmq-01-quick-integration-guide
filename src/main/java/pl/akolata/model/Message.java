package pl.akolata.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Message implements Serializable {
    private String id = UUID.randomUUID().toString();
    private String msg;
}
