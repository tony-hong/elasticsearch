/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.search;

import org.elasticsearch.common.xcontent.XContentParser;

import java.io.IOException;

/**
 * Defines a parser that is able to parse {@link org.elasticsearch.search.SearchExtBuilder}s
 * from {@link org.elasticsearch.common.xcontent.XContent}.
 *
 * Registration happens through {@link org.elasticsearch.plugins.SearchPlugin#getSearchExts()}, which also needs a {@link SearchExtBuilder}
 * implementation which is the object that this parser returns when reading an incoming request form the REST layer.
 *
 * @see SearchExtBuilder
 * @see org.elasticsearch.plugins.SearchPlugin.SearchExtSpec
 */
@FunctionalInterface
public interface SearchExtParser<T extends SearchExtBuilder> {

    /**
     * Parses the supported element placed within the ext section of a search request
     */
    T fromXContent(XContentParser parser) throws IOException;
}
