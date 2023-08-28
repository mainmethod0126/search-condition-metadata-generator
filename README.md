# search condition metadata generator

This library provides metadata on what searches are possible for domain objects

## Usage

### Example

Here is an example of metadata generation for the 'TestOrder' domain class.

> There are also several other classes such as TestCustomer and TestProduct. For detailed information about these classes, please refer to the source code. Thank you.

```java
public class TestOrder {
    private String description;

    private TestCustomer customer;

    private List<TestProduct> products;

    private Map<String, TestShippingInfo> shippingInfo;
}
```

```java
public class MetaDataGeneratorTest {

    @Test
    @DisplayName("Generates metadata from a valid domain class")
    public void testGenerator_whenNormalParam_thenSuccess() {

        String result = MetaDataGenerator.generate(TestOrder.class);

        System.out.println("metadata : " + result);

        assertThat(result).isNotNull().isNotEmpty();

    }

}
```

#### Result

```bash
metadata : [
  {
    "name": "description",
    "type": "string",
    "operators": ["=", "!=", "in", "not in", "regex", "wildcard"]
  },
  {
    "name": "customer.user.id",
    "type": "number",
    "operators": ["=", "!=", ">=", "<=", ">", "<"]
  },
  {
    "name": "customer.user.name",
    "type": "string",
    "operators": ["=", "!=", "in", "not in", "regex", "wildcard"]
  },
  {
    "name": "customer.description",
    "type": "string",
    "operators": ["=", "!=", "in", "not in", "regex", "wildcard"]
  },
  {
    "name": "products.name",
    "type": "string",
    "operators": ["=", "!=", "in", "not in", "regex", "wildcard"]
  },
  {
    "name": "products.price",
    "type": "number",
    "operators": ["=", "!=", ">=", "<=", ">", "<"]
  },
  {
    "name": "shippingInfo.productId",
    "type": "number",
    "operators": ["=", "!=", ">=", "<=", ">", "<"]
  },
  {
    "name": "shippingInfo.quantity",
    "type": "string",
    "operators": ["=", "!=", "in", "not in", "regex", "wildcard"]
  },
  {
    "name": "shippingInfo.wrapping.style",
    "type": "string",
    "operators": ["=", "!=", "in", "not in", "regex", "wildcard"]
  }
]
```