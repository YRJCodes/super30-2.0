package com.oms.work;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface workrepo extends JpaRepository<Work,Long>{

	List findByEmployeeId(Long id);

}
