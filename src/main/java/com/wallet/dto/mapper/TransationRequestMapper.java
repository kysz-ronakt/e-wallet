package com.wallet.dto.mapper;

import com.wallet.dto.request.TransactionRequest;
import com.wallet.model.Transaction;
import com.wallet.service.TypeService;
import com.wallet.service.WalletService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring",
        uses = {WalletService.class, TypeService.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public abstract class TransationRequestMapper {

    @Autowired
    private WalletService walletService;

    @Autowired
    private TypeService typeService;

    // set default value of the status field as Status.SUCCESS
    @Mapping(target = "status", expression = "java(com.github.yildizmy.model.Status.SUCCESS)")
    @Mapping(target = "referenceNumber", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(source = "createdAt", target = "createdAt", defaultExpression = "java(java.time.Instant.now())")
    @Mapping(target = "fromWallet", ignore = true)
    @Mapping(target = "toWallet", ignore = true)
    @Mapping(target = "type", ignore = true)
    public abstract Transaction toEntity(TransactionRequest dto);

    public abstract TransactionRequest toDto(Transaction entity);

    @AfterMapping
    void setToEntityFields(@MappingTarget Transaction entity, TransactionRequest dto) {
        entity.setFromWallet(walletService.getByRonak(dto.getFromWalletRonak()));
        entity.setToWallet(walletService.getByRonak(dto.getToWalletRonak()));
        entity.setType(typeService.getReferenceById(dto.getTypeId()));
    }
}
