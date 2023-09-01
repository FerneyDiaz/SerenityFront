package com.avaldigitallabs.facilpass.helper.dynamo;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;

import java.util.Objects;
import java.util.logging.Logger;

public class DynamoConnection {

    private AmazonDynamoDB amazonDynamoDB =
            AmazonDynamoDBAsyncClientBuilder.standard().withRegion(Regions.US_EAST_2).build();
    private DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
    private final String ELEMENT_P = "#p";
    private final String ELEMENT_VAL1=":val1";
    private final String EXPRESSION_UPDATE="set "+ELEMENT_P+" = "+ELEMENT_VAL1;

    public Item getElementTableByKey(String tableName, String attributeKey, String key){
        Table table = dynamoDB.getTable(tableName);
        GetItemSpec getItemSpec = new GetItemSpec().withPrimaryKey(attributeKey,key);
        try {
            Item item = table.getItem(getItemSpec);
            if (Objects.nonNull(item)){
                return item;
            }
        }catch (Exception e){
            Logger.getLogger("Problems to get objects in dynamo: " + e.getMessage());
        }
        return null;
    }

    public void updateBooleanElement(String tableName, String id, String idValue,
                              String idItem, Boolean idItemValue){
        Table table = dynamoDB.getTable(tableName);
        try {
            UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey(id,idValue)
                    .withReturnValues(ReturnValue.ALL_NEW).withUpdateExpression(EXPRESSION_UPDATE)
                    .withNameMap(new NameMap().with(ELEMENT_P, idItem))
                    .withValueMap(new ValueMap().withBoolean(ELEMENT_VAL1, idItemValue));
            table.updateItem(updateItemSpec);
        }catch (Exception e){
            Logger.getLogger("Error updating table " + tableName + " " + e.getMessage());
        }

    }
}
