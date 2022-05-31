package com.lpnu.iot.term2.lab8.recources;


import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Weapon {

    public static final int DEFAULT_QUALITY = 100;

    @Id
    @SequenceGenerator(
            name = "weapon_sequence",
            sequenceName = "weapon_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "weapon_sequence"
    )
    public Long id;
    public int quality;
}
