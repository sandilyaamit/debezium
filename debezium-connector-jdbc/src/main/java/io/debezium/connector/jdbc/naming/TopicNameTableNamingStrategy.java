package io.debezium.connector.jdbc.naming;

import io.debezium.connector.jdbc.JdbcSinkConnectorConfig;
import org.apache.kafka.connect.data.Struct;
import org.apache.kafka.connect.sink.SinkRecord;

public class TopicNameTableNamingStrategy implements TableNamingStrategy {

    @Override
    public String resolveTableName(JdbcSinkConnectorConfig config, SinkRecord record) {
        // Get the value of the SinkRecord
        Struct valueStruct = (Struct) record.value();

        // Check if the valueStruct is not null
        if (valueStruct != null) {
            // Extract the 'source' struct from the value
            Struct sourceStruct = valueStruct.getStruct("source");

            // Check if the sourceStruct is not null and extract the 'table' field
            if (sourceStruct != null) {
                String tableName = sourceStruct.getString("table");
                return tableName; // Return the table name
            }
        }

        // If unable to extract, fall back to the default behavior
        return null; // Or handle as needed
    }

}
