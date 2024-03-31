package tn.esprit.rh.achat.controllers;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.services.IStockService;

import java.util.List;

@RestController
@Api(tags = "Gestion des stocks")
@RequestMapping("/stock")
@CrossOrigin("*")
public class StockRestController {
	private final IStockService stockService;

	@Autowired
	public StockRestController(IStockService stockService) {
		this.stockService = stockService;
	}

	// http://localhost:8089/SpringMVC/stock/retrieve-all-stocks
	@GetMapping("/retrieve-all-stocks")
	public List<Stock> getStocks() {
		return stockService.retrieveAllStocks();
	}
	// http://localhost:8089/SpringMVC/stock/retrieve-stock/8
	@GetMapping("/retrieve-stock/{stock-id}")
	public Stock retrieveStock(@PathVariable("stock-id") Long stockId) {
		return stockService.retrieveStock(stockId);
	}
	// http://localhost:8089/SpringMVC/stock/add-stock
	@PostMapping("/add-stock")
	public Stock addStock(@RequestBody Stock s) {
		return stockService.addStock(s);
	}
	@DeleteMapping("/remove-stock/{stock-id}")
	public void removeStock(@PathVariable("stock-id") Long stockId) {
		stockService.deleteStock(stockId);
	}
	// http://localhost:8089/SpringMVC/stock/modify-stock
	@PutMapping("/modify-stock")
	public Stock modifyStock(@RequestBody Stock stock) {
		return stockService.updateStock(stock);
	}
}