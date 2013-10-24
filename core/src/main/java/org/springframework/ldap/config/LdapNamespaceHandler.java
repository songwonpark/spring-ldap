/*
 * Copyright 2005-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.ldap.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.springframework.data.repository.config.RepositoryBeanDefinitionParser;
import org.springframework.ldap.repository.config.LdapRepositoryConfigurationExtension;

/**
 * @author Mattias Hellborg Arthursson
 */
public class LdapNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        LdapRepositoryConfigurationExtension extension = new LdapRepositoryConfigurationExtension();
        RepositoryBeanDefinitionParser repositoryParser = new RepositoryBeanDefinitionParser(extension);

        registerBeanDefinitionParser(Elements.CONTEXT_SOURCE, new ContextSourceParser());
        registerBeanDefinitionParser(Elements.LDAP_TEMPLATE, new LdapTemplateParser());
        registerBeanDefinitionParser(Elements.TRANSACTION_MANAGER, new TransactionManagerParser());
        registerBeanDefinitionParser(Elements.REPOSITORIES, repositoryParser);
    }
}