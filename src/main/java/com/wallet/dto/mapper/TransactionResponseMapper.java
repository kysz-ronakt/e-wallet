package com.wallet.dto.mapper;

import com.wallet.model.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionResponseMapper {

    Transaction toEntity();
}
