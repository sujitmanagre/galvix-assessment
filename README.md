# Order Summary API

This Spring Boot API parses a JSONLines file containing online order data and returns a summary of the orders in
JSON/XML/CSV/XML format. Each order summary includes information such as order ID, order date, total order value,
average unit price, unit count, and customer state.

## Getting Started

To run the API locally, follow these steps:

1. Clone this repository to your local machine.
2. Open the project in your preferred IDE.
3. Build and run the project using Gradle.
4. Make a POST request to the `orders/summary` endpoint with the following parameters:
    - `file`: The JSONLines file containing the online order data.
    - `fileType`: The type of file (jsonl, currently jsonl is supported as an input file).
    - `responseType`: The desired response format (JSON, YAML, XML, CSV). It should be among these four enums only.
    - `page`: The page number for pagination (default is 0).
    - `size`: The number of orders per page (default is 10).

## Dependencies

This project utilizes the following dependencies for response generation:

- `com.fasterxml.jackson.datatype:jackson-datatype-jsr310`: For handling Java 8 date/time types.
- `org.apache.commons:commons-csv:1.8`: For generating CSV responses.
- `com.fasterxml.jackson.dataformat:jackson-dataformat-yaml`: For generating YAML responses.
- `com.fasterxml.jackson.dataformat:jackson-dataformat-xml`: For generating XML responses.

## Implementation Details

- The API parses the JSONLines file line by line, parsing only the required orders based on pagination parameters.
- After parsing, it generates order summary responses depending on the specified response type.
- Response generation is handled by different response generators based on the response type.
- Validation is performed for the file and file type to ensure they match.

## Bonus Points

- **Multiple Response Formats**: The API supports multiple response formats, including JSON, YAML, XML, and CSV.
- **Third-Party Libraries**: Third-party libraries have been used for handling CSV, XML, and YAML formats.
- **Validation of API Response**: The API response can be validated using tools like Postman.
- **Exception Handling**: Comprehensive exception handling has been implemented to handle errors and exceptions
  gracefully. Additionally, a custom exception class has been provided for better error management.

## Future Improvements

- Implement additional features, such as geolocating customers' addresses.
- Improve test coverage and add integration tests.
- Enhance error handling and validation.

## Example API Request

To retrieve a summary of orders using the API, you can make a POST request to the `localhost:8080/orders/summary`
endpoint. Below is an
example cURL command:

```bash
curl --location 'localhost:8080/orders/summary' \
--form 'file=@"/C:/Users/Dell/Downloads/coding-challenge.jsonl"' \
--form 'fileType="jsonl"' \
--form 'responseType="JSON"' \
--form 'page="2"' \
--form 'size="10"'
