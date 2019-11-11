package com.annamakos.socialcare.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "messages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String content;

    @NotBlank
    private Date time;

    @ManyToOne
    private User receiver;

    @ManyToOne
    private User sender;

    public Message(@NotBlank String content, @NotBlank Date time) {
        this.content = content;
        this.time = time;
    }
}
