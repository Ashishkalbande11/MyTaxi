package com.example.RideIt.DTO.Request;

import com.example.RideIt.Model.Cab;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DriverRequest {
    String name;

    int age;

    String panNo;

    String mobNo;

    CabRequest cab;
}
