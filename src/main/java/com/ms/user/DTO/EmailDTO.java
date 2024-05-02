package com.ms.user.DTO;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EmailDTO {

    private UUID userId;
    private String emailTo;
    private String subject;
    private String text;
}
