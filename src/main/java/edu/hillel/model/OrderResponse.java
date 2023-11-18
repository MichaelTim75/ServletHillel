package edu.hillel.model;

import com.google.gson.annotations.JsonAdapter;
import edu.hillel.util.GsonLocalDateAdapter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
@Builder
@ToString
public class OrderResponse {
    private int id;

    @JsonAdapter(GsonLocalDateAdapter.class)
    private LocalDate date;
    private BigDecimal cost;
    private List<Product> products;

    public OrderResponse(Order order, List<Product> products) {
        this.id = order.getId();
        this.date = order.getDate();
        this.cost = order.getCost();
        this.products = products;
    }
}
