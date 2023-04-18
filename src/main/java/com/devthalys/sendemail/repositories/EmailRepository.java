package com.devthalys.sendemail.repositories;

import com.devthalys.sendemail.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailModel, Long> {

}
