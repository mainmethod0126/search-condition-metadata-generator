
<!-- TOC -->

- [search condition metadata generator](#search-condition-metadata-generator)
  - [Usage](#usage)
    - [Example](#example)
      - [Default](#default)
      - [Specifying a Value Directly Using @MetaDataField](#specifying-a-value-directly-using-metadatafield)

<!-- /TOC -->

# search condition metadata generator

This library provides metadata on what searches are possible for domain objects

## Usage

---

### Example

Here is an example of metadata generation for the 'TestOrder' domain class.

#### Default

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

**Result**

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

#### Specifying a Value Directly Using @MetaDataField

You can use the @MetaDataField annotation when you want to use a separate value other than the one that defaults.

**The metadata field annotation is only applied to the last primitive-type field of the domain object. If the annotation is added to a non-primitive type, it will not work and will be ignored.**

**Proper Functioning**

```java
public class TestUser {

    @MetaDataField(name = "uuid", type = "number", operators = {"=", "!="})
    private Long id;

    private String name;

}
```

**Ignored**

```java
public class TestOrder {

    private String description;

    // @MetaDataField Ignored Cases
    @MetaDataField(name = "king", type = "string", operators = {"=", "!="})
    private TestCustomer customer;

    private List<TestProduct> products;

    private Map<String, TestShippingInfo> shippingInfo;
}
```

**Result**

```bash
metadata : [
  {
    "name": "description",
    "type": "string",
    "operators": ["=", "!=", "in", "not in", "regex", "wildcard"]
  },
  { "name": "customer.user.uuid", "type": "number", "operators": ["=", "!="] }, <---- The point where the @MetaDataField was applied
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