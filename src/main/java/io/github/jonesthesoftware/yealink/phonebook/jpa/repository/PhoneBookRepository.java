/**
 * Copyright (C) 2020 Wayne Jones
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package io.github.jonesthesoftware.yealink.phonebook.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.jonesthesoftware.yealink.phonebook.jpa.type.Directory;

public interface PhoneBookRepository extends JpaRepository<Directory, Short> {

}
