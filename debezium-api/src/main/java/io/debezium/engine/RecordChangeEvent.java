/*
 * Copyright Debezium Authors.
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package io.debezium.engine;

/**
 * A data change event described as a single object.
 *
 * @param <V>
 */
public interface RecordChangeEvent<V> {

    V record();
}
