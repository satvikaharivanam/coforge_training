package com.coforge.sms.service;

import java.util.List;
import java.util.Optional;

import com.coforge.sms.model.Supplier;

import jakarta.validation.Valid;

public interface SupplierService {

	boolean saveSupplier(@Valid Supplier supplier);

	boolean updateSupplierById(int supplierId, @Valid Supplier supplier);

	boolean deleteSupplierById(int supplierId);

	Optional<Supplier> findSupplierById(int supplierId);

	List<Supplier> findAllSuppliers();

}
