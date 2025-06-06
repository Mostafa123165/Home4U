package com.service.common.service;

import com.service.common.model.OrderNumberSeq;
import com.service.common.repository.OrderNumberSeqRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class OrderNumberSeqService {

    private static final String PREFIX = "ORD-";
    private final OrderNumberSeqRepository orderNumberSeqRepository;

    @Transactional
    public synchronized String generateOrderNumber() {
        OrderNumberSeq orderNumberSeq = orderNumberSeqRepository.findNextOrderNumber();
        if (orderNumberSeq == null) {
            orderNumberSeq = new OrderNumberSeq();
            orderNumberSeq.setNextVal(1L);
            orderNumberSeq = orderNumberSeqRepository.save(orderNumberSeq);
        }

        Long currentValue = orderNumberSeq.getNextVal();
        orderNumberSeq.setNextVal(currentValue + 1);
        orderNumberSeqRepository.save(orderNumberSeq);

        return PREFIX + LocalDate.now().getYear() + StringUtils.leftPad(String.valueOf(currentValue), 6, '0');
    }
}
