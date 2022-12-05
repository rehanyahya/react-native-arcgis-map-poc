import React, {useEffect} from 'react';
import {View, Text, StyleSheet} from 'react-native';
import ArcGISMap from './ArcGISMap';

const App = () => {
  useEffect(() => {
    ArcGISMap.openMap();
  }, []);
  return <View style={styles.container}>{/* <Text>HIIII</Text> */}</View>;
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
});

export default App;
