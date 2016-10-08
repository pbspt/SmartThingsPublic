/**
 *  Close my garage door
 *
 *  Copyright 2016 Phillip Seymore
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
definition(
    name: "Close my garage door",
    namespace: "pseymore",
    author: "Phillip Seymore",
    description: "Close the garage door when I leave",
    category: "Convenience",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")


preferences {
    section("Close when presence no longer detected:") {
        input "thepresence", "capability.presenceSensor", title: "presence", required: true, multiple: true
    input "doorSwitch", "capability.garageDoorControl", title: "garagedoor", required: true, multiple: true
  }
}

def installed() {
  subscribe(presence, "presence", "RG Linear GD00Z Garage Door Opener")
}

def "RG Linear GD00Z Garage Door Opener"(evt) {
  if("not present" == evt.value) {
    doorSwitch.close()
  } 
}
