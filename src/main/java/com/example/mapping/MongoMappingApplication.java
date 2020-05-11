package com.example.mapping;

import com.example.mapping.domain.model.entity.expedition.Expedition;
import com.example.mapping.domain.model.entity.expedition.ExpeditionStatus;
import com.example.mapping.domain.model.entity.invoice.InvoiceOrder;
import com.example.mapping.domain.model.entity.invoice.InvoiceOrderStatus;
import com.example.mapping.domain.model.entity.movement.Movement;
import com.example.mapping.domain.model.entity.movement.MovementDocument;
import com.example.mapping.domain.model.repository.ExpeditionRepository;
import com.example.mapping.domain.model.repository.InvoiceOrderRepository;
import com.example.mapping.domain.model.repository.MovementDocumentRepository;
import com.example.mapping.domain.model.repository.MovementRepository;
import com.example.mapping.domain.model.repository.OrderItemRepository;
import com.example.mapping.domain.model.entity.Brand;
import com.example.mapping.domain.model.entity.OrderItem;
import com.example.mapping.domain.model.entity.invoice.Invoice;
import com.example.mapping.domain.model.entity.invoice.InvoiceStatus;
import com.example.mapping.domain.model.entity.movement.MovementType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class MongoMappingApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(MongoMappingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MongoMappingApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner(ExpeditionRepository expeditionRepository,
											   OrderItemRepository orderItemRepository,
											   InvoiceOrderRepository invoiceOrderRepository,
											   MovementDocumentRepository movementDocumentRepository,
											   MovementRepository movementRepository) {
		return args -> {
			final Expedition expedition = createExpedition(expeditionRepository, orderItemRepository);

			final InvoiceOrder invoiceOrder = new InvoiceOrder(expedition.getExpeditionId(), 27375);
			invoiceOrder.setInvoiceOrderStatus(InvoiceOrderStatus.Received);
			final InvoiceOrder savedOrder = invoiceOrderRepository.save(invoiceOrder);

			expedition.setInvoiceOrders(new HashSet<>(Collections.singleton(savedOrder)));
			expeditionRepository.save(expedition);

			final Invoice invoice = new Invoice(savedOrder.getInvoiceOrderId(), 172414);
			invoice.setInvoiceStatus(InvoiceStatus.InProcessing);
			savedOrder.setInvoice(invoice);
			invoiceOrderRepository.save(savedOrder);

			final MovementDocument movementDocument = new MovementDocument(expedition.getExpeditionId(), invoice.getInvoiceId(),
					823425, MovementType.TM80, 147141);
			final MovementDocument document = movementDocumentRepository.save(movementDocument);

			invoice.setMovementDocuments(new HashSet<>(Collections.singleton(document)));
			invoiceOrder.setInvoice(invoice);
			invoiceOrderRepository.save(invoiceOrder);

			final Movement movement = new Movement(document.getMovementDocumentId(), 14149);
			final Movement savedMovement = movementRepository.save(movement);

			savedMovement.setOrderItems(expedition.getOrderItems());
			movementRepository.save(savedMovement);

			document.setMovements(new HashSet<>(Collections.singleton(movement)));
			movementDocumentRepository.save(document);
		};
	}

	private Expedition createExpedition(ExpeditionRepository expeditionRepository, OrderItemRepository orderItemRepository) {
		final long expeditionId = 123L;
		final Expedition expedition = new Expedition(expeditionId, ExpeditionStatus.CREATED);

		expedition.setExpeditionDate(LocalDate.now());
		expedition.setWarehouseCode("OY-ZLND-DE");
		expedition.setBrand(Brand.Pull_and_Bear);

		Set<OrderItem> orderItems = new HashSet<>();
		orderItems.add(new OrderItem(expeditionId, "31237123712-2133218", 10));
		orderItems.add(new OrderItem(expeditionId, "54352371243-5155325", 20));
		expedition.setOrderItems(orderItems);

		expedition.setTotalExpeditionPieces(124);

		orderItemRepository.saveAll(orderItems);
		expeditionRepository.save(expedition);

		LOGGER.info("The expedition was saved");

		return expedition;
	}
}
