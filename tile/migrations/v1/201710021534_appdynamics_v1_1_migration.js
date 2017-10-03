exports.migrate = function(input) {
  // To view JavaScript console logs in the Rails debug log, be sure to make them single value and to only pass them
  // strings.  JSON.stringify is an easy way to dump a structure.
  console.log('the properties passed to migrate are: ');
  console.log(JSON.stringify(input));
  var current_version = getCurrentProductVersion(); // Changing a selector option
  console.log('Current Product Version: '+current_version);
//  var currentPepperoniValue = input.properties['.properties.example_selector.pizza_option.pepperoni'].value;
//  input.properties['.properties.example_selector.pizza_option.pepperoni'].value = !currentPepperoniValue;
  var old_service_broker_org_val = input.properties['.properties.org_quota'].value;
  input.properties['.properties.org_quota'].value = 2048;
  console.log('Old Service Broker Org Quota: ' + old_service_broker_org_val);
  console.log('New Service Broker Org Quota: ' + input.properties['.properties.org_quota'].value);
  var old_service_broker_mem_val = input.properties['.properties.memory'].value;
  input.properties['.properties.memory'].value = 1024;
  console.log('Old Service Broker Memory Value: ' + old_service_broker_mem_val);
  console.log('New Service Broker Memory Value: ' + input.properties['.properties.memory'].value);
  return input;
};
