package edu.hillel.model;

import com.google.gson.annotations.JsonAdapter;
import edu.hillel.util.GsonLocalDateAdapter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Order {
    private int id;

    @JsonAdapter(GsonLocalDateAdapter.class)
    private LocalDate date;
    private BigDecimal cost;
    private int[] productIds;
}
