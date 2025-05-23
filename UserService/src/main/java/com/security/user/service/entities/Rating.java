package com.security.user.service.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Rating {

    @Id
    private String ratingId;
    private String userId;
    private String hotelId;
    private  int rating;
    private String feedback;

    @Transient
    private Hotel hotel;
}
