<template>
  <div>
    <!-- <Avatar></Avatar> -->
    <h1>疫情数据可视化主页面</h1>
    <router-link to="/login">
      login
    </router-link>
    <router-link to="/register">
      register
    </router-link>
    <Overview :today="show.currentAreaTypes[0]" :yesterday="show.currentAreaTypes[1]"></Overview>
    <ChinaMap :mapData="show.chinaMapDataBycurrentType" :key="JSON.stringify(show.chinaMapDataBycurrentType)"></ChinaMap>

  </div>
</template>

<script>
import Avatar from '@/layout/components/Avatar'
import visualizationApi from '@/api/visualization'

import ChinaMap from "./components/ChinaMap";
import Overview from "./components/Overview";
import DetailVisualMapHorizontal from "./components/DetailVisualMapHorizontal";
import Pie4 from "./components/Pie4";
import Roma from "./components/Roma";

export default {
  name: 'Covid19Visualization',
  components: {
    Avatar,
    ChinaMap,
    Overview,
    Roma,
    DetailVisualMapHorizontal,
    Pie4,
  },
  data() {
    return {
      weekData: [], //一周的数据
      currentAreaName: '河南',
      currentType: 'confirm',
      show: {
        chinaMapDataBycurrentType: [],
        currentArea: [],
        nameAndValueOnCurrentAreaBycurrentType: [],
        currentAreaChildNameAndValueOnCurrentAreaBycurrentType: [],
        currentAreaTypes: []
      }
    }
  },
  watch: {
    weekData() {

    },
    currentAreaName() {
      this.setShow()
      // console.log(this.show.currentArea)
    },
    currentType() {
      console.log()
      this.setShow(this.currentType)
    }
  },


  created() {
    visualizationApi.queryAWeek().then((res) => {
      this.weekData = res.data.week
      // console.log(this.show.currentAreaTypes)
      this.setShow()
    })
  },

  mounted() {
  },

  methods: {
    findCurrentArea(rootArea, findAreaName) {
      if (rootArea.name == findAreaName) {
        return rootArea
      }
      let areas = rootArea.children
      // console.log(areas)
      for (let index = 0; index < areas.length; index++) {
        const element = areas[index];
        if (element.name == findAreaName) {
          return element
        }
      }
      return null


      // if (area.name == this.currentAreaName) {
      //   return area
      // } else {
      //   // console.log(area.name)
      //   let areas = area.children
      //   console.log(areas)
      //   if (areas == null) {
      //     return null
      //   } else {
      //     // console.log(area)
      //     for (let index = 0; index < areas.length; index++) {
      //       const element = areas[index];
      //       // console.log(element)
      //       return findCurrentArea(element)
      //     }
      //     return null
      //   }
      // }
    },


    areaNameAndValueByCurrentType(item) {
      let valueType;
      switch (this.currentType) {
        case "currentConfirm":
          valueType = item.currentConfirm;
          break;
        case "confirm":
          valueType = item.confirm;
          break;
        case "suspect":
          valueType = item.suspect;
          break;
        case "cure":
          valueType = item.cure;
          break;
        case "dead":
          valueType = item.dead;
          break
        default:
          valueType = 0
          break;
      }
      return {
        name: item.name,
        value: valueType,
      };
    },
    AreaTypes(item) {
      return {
        currentConfirm: item.currentConfirm,
        confirm: item.confirm,
        suspect: item.suspect,
        cure: item.cure,
        dead: item.dead,
      };
    },





    setCurrentArea(areaName) {
      this.currentAreaName = areaName
    },
    setCurrentType(type){
      this.currentType=type
    },


    setShow() {
      this.show.currentArea = this.weekData.map(item => this.findCurrentArea(item, this.currentAreaName))
      this.show.nameAndValueOnCurrentAreaBycurrentType = this.show.currentArea.map((item) => this.areaNameAndValueByCurrentType(item))
      this.show.chinaMapDataBycurrentType = this.weekData[0].children.map(item => this.areaNameAndValueByCurrentType(item, this.currentAreaName))
      this.show.nameAndValueOnCurrentAreaBycurrentType = this.show.currentArea[0].children.map(item => this.areaNameAndValueByCurrentType(item, this.currentAreaName))
      this.show.currentAreaTypes = this.show.currentArea.map(item => this.AreaTypes(item))

    }
  }



}
</script>
