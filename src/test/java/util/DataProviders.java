package util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataProviders {

	@DataProvider
	public Object[][] jsonDataProvider() throws IOException {

		// Path to JSON file
		String filePath = ".\\testData\\products.json";

		// Read JSON file and map it to a List of Maps
		ObjectMapper objectMapper = new ObjectMapper();
		List<Map<String, String>> dataList = objectMapper.readValue(
				new File(filePath),
				new TypeReference<List<Map<String, String>>>() {
				});

		// Convert List<Map<String, String>> to Object[][]
		Object[][] dataArray = new Object[dataList.size()][1];
		for (int i = 0; i < dataList.size(); i++) {
			dataArray[i][0] = dataList.get(i);
		}

		return dataArray;
	}
}
