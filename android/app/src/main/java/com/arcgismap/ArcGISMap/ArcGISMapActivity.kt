package com.arcgismap.ArcGISMap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.esri.arcgisruntime.ArcGISRuntimeEnvironment
import com.esri.arcgisruntime.data.ServiceFeatureTable
import com.esri.arcgisruntime.layers.FeatureLayer
import com.esri.arcgisruntime.mapping.ArcGISMap
import com.esri.arcgisruntime.mapping.BasemapStyle
import com.esri.arcgisruntime.mapping.Viewpoint
import com.esri.arcgisruntime.mapping.view.MapView

import com.arcgismap.databinding.ActivityArcGisMapBinding

class ArcGISMapActivity : AppCompatActivity() {

    private val activityArcGisMapBinding by lazy {
        ActivityArcGisMapBinding.inflate(layoutInflater)
    }

    private val mapView: MapView by lazy {
        activityArcGisMapBinding.mapView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityArcGisMapBinding.root)
        setApiKeyForApp()
        setupMap()
    }

    override fun onPause() {
        mapView.pause()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        mapView.resume()
    }

    override fun onDestroy() {
        mapView.dispose()
        super.onDestroy()
    }

    private fun setApiKeyForApp(){
        ArcGISRuntimeEnvironment.setApiKey("AAPK9bd7853893714bf789264645c53e8745qFLUjYr0p7lG5MDGeswVrFwxuiZnxguRhibEIa-dk4cB3RTdmu1STKZdQo_OmokM")
    }

    private fun setupMap() {
        val map = ArcGISMap(BasemapStyle.ARCGIS_TOPOGRAPHIC)
//        val serviceFeatureTable = ServiceFeatureTable("https://services.gisqatar.org.qa/server/rest/services/Vector/Qatar_StreetMap_Hybrid_E/MapServer/2")
        val serviceFeatureTable = ServiceFeatureTable("https://services.gisqatar.org.qa/server/rest/services/Vector/QARS_COMMERCIAL/FeatureServer/0")
        val featureLayer = FeatureLayer(serviceFeatureTable)
        map.operationalLayers.add(featureLayer)
        mapView.map = map
        mapView.setViewpoint(Viewpoint(25.2854, 51.5310, 200000.0))
    }

}