package com.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Enitities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

	public List<Company> findByAddrPin(String pin);

	public Optional<Company> findByGstNo(Integer gstNo);

}
