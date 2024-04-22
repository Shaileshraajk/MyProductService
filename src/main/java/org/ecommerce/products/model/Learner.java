package org.ecommerce.products.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Learner extends User{

    private String university;
    private Double psp;
}
