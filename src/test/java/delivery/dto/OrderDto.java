package delivery.dto;
import com.github.javafaker.Faker;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OrderDto {

    private String status;
    private int courierId;
    private String customerName;
    private String customerPhone;
    private String comment;
    int id;

    // static method to use factory
    public static OrderDto createRandomOrder() {
        Faker faker = new Faker();
        return OrderDto.builder()
                .status("OPEN")
                .courierId(0)
                .customerName(faker.name().firstName())
                .customerPhone("56757575")
                .comment(faker.funnyName().name())
                .id(0)
                .build();
    }
}