exports.migrate = function(input) {
  // To view JavaScript console logs in the Rails debug log, be sure to make them single value and to only pass them
  // strings.  JSON.stringify is an easy way to dump a structure.
  console.log('the properties passed to migrate are: ');
  console.log(JSON.stringify(input));
  var current_version = getCurrentProductVersion(); // Changing a selector option
  console.log('Current Product Version: '+current_version);
//  var currentPepperoniValue = input.properties['.properties.example_selector.pizza_option.pepperoni'].value;
//  input.properties['.properties.example_selector.pizza_option.pepperoni'].value = !currentPepperoniValue;

  return input;
};
