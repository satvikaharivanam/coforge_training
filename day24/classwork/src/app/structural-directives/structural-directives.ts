import { Component } from '@angular/core';

@Component({
  selector: 'app-structural-directives',
  standalone: false,
  templateUrl: './structural-directives.html',
  styleUrl: './structural-directives.css',
})
export class StructuralDirectives {

  myDivStyle : string;
  myButtonStyle : {};
  message : string;
  flag : boolean;
  vehicles : string[];
  selectedVehicle : string;
  constructor(){
    this.myDivStyle = "MyDiv";
    this.myButtonStyle = {"background-color" : "blue", "color" : "white", "padding" : "10px",  "border" : "2px solid black"}
    this.message = "Angular structural directives"
    this.flag = true;
    this.vehicles = ['Car', 'Bike', 'Bus', 'Truck'];
    this.selectedVehicle = "";
  }

  showHideDiv() {
    this.flag = !this.flag;
  }

  setSelectedVehicle(vehicle : string) {
    this.selectedVehicle = vehicle;
  }

}
