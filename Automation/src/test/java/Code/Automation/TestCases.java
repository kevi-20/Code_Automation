package Code.Automation;

public class TestCases {

# Wait until all the elements in the DOM are available
wait = new WebDriverWait();
wait.until(new EC.PresenceOfAllElementsLocated(By.CSS_SELECTOR, "body"))); 
  
# Scroll to the 'SEE ALL INTEGRATIONS' link
see_all_integrations_link = driver.findElement(By.xpath("//a[contains(text(), 'SEE ALL INTEGRATIONS')]");
driver.execute_script("arguments[0].scrollIntoView();", see_all_integrations_link)

# Click on the 'SEE ALL INTEGRATIONS' link and ensure it opens in a new tab
see_all_integrations_link.click()
original_window_handle = driver.current_window_handle
all_window_handles = driver.window_handles
new_window_handle = [handle for handle in all_window_handles if handle != original_window_handle][0]
driver.switch_to.window(new_window_handle)

# Verify the URL of the new window
expected_url = "https://www.lambdatest.com/integrations"
assert driver.current_url == expected_url, f"URL not matching. Expected: {expected_url}, Actual: {driver.current_url}"

# Scroll to the 'Codeless Automation' link
codeless_automation_link = driver.findElement(By.xpath("//a[contains(text(), 'Codeless Automation')]")
driver.execute_script("arguments[0].scrollIntoView();", codeless_automation_link)

# Click on the 'LEARN MORE' link for Testing Whiz
learn_more_link = codeless_automation_link.driver.findElement(By.xpath("//a[contains(text(), 'LEARN MORE')]")
learn_more_link.click()

# Verify the title of the page
String ActualTitle = driver.getTitle();
String ExpectedTitle = "TestingWhiz Integration | LambdaTest";
Assert.assertEquals(ExpectedTitle, ActualTitle)

# Close the current window
driver.close()

# Print the current window count
print(f"Current window count: {len(driver.window_handles)}")

# Set the URL to https://www.lambdatest.com/blog
driver.switch_to.window(original_window_handle)
driver.get("https://www.lambdatest.com/blog")

# Click on the 'Community' link and verify the URL
community_link = driver.find_element(By.XPATH, "//a[contains(text(), 'Community')]")
community_link.click()
expected_url = "https://community.lambdatest.com/"
assert driver.current_url == expected_url, f"URL not matching. Expected: {expected_url}, Actual: {driver.current_url}"

# Close the current window
driver.close()

# Quit the WebDriver instance
driver.quit()

  
  
}
