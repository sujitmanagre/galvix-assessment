package com.galvix.galvixassessment.service.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import com.galvix.galvixassessment.dto.Order;
import com.galvix.galvixassessment.dto.OrderSummary;
import com.galvix.galvixassessment.service.ResponseGenerator;

public class CsvResponseGeneratorImpl implements ResponseGenerator {
	@Override
	public Object generateResponse(List<Order> orders) throws IOException {
		List<OrderSummary> orderResponse = ResponseGenerator.generateJsonResponse(orders);
		StringWriter writer = new StringWriter();
		try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("orderId", "orderDate",
				"totalOrderValue", "averageUnitPrice", "unitCount", "customerState"))) {
			for (OrderSummary order : orderResponse) {
				csvPrinter.printRecord(order.getOrderId(), order.getOrderDate(), order.getTotalOrderValue(),
						order.getAverageUnitPrice(), order.getUnitCount(), order.getCustomerState());
			}
		} catch (Exception e) {
			throw e;
		}
		return writer.toString();
	}
}
