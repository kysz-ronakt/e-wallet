package com.wallet.dto.request;

import com.wallet.model.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Data
public class TransactionRequest {
    private Long id;

    @NotNull(message = "{amount.notnull}")
    private BigDecimal amount;

    @Size(max = 50, message = "{description.size}")
    private String description;

    private Instant createdAt;

    private UUID referenceNumber;

    private Status status;

    @NotBlank(message = "fromWalletIban.notblank}")
    private String fromWalletRonak;

    @NotBlank(message = "{toWalletIban.notblank}")
    private String toWalletRonak;

    @NotNull(message = "{typeId.notnull}")
    private Long typeId;
}
