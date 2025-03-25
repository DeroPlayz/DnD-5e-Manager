import json
import os

def extract_and_remove_features(input_directory, output_directory):
    """
    Extracts features from JSON files, saves each feature to its own JSON file,
    and removes the extracted features from the original files.

    Args:
        input_directory (str): The directory containing the JSON files.
        output_directory (str): The directory to save the feature files.
    """

    os.makedirs(output_directory, exist_ok=True)

    for filename in os.listdir(input_directory):
        if filename.endswith(".json"):
            filepath = os.path.join(input_directory, filename)
            try:
                with open(filepath, "r+") as f: # open file for both read and write
                    data = json.load(f)
                    if "features" in data and isinstance(data["features"], list):
                        features = data["features"]
                        new_features = [] #create a new list to store features that are not feats.
                        for feature_container in features:
                            if isinstance(feature_container, dict) and "feat" in feature_container:
                                feature = feature_container["feat"]
                                if isinstance(feature, dict) and "name" in feature:
                                    feature_name = feature["name"].replace(" ", "").replace("/", "")
                                    feature_filename = f"{feature_name}.json"
                                    feature_filepath = os.path.join(output_directory, feature_filename)
                                    with open(feature_filepath, "w") as feature_file:
                                        json.dump(feature, feature_file, indent=4)
                                else:
                                    print(f"Warning: Invalid feature format in {filename}: {feature}")
                            else:
                                new_features.append(feature_container) #if not a feat, add it to the new_features list.

                        data["features"] = new_features #replace the old features list with the new one.
                        f.seek(0) #go to the beginning of the file
                        json.dump(data, f, indent=4) #write the new data to the file
                        f.truncate() #remove the rest of the old data.

                    else:
                        print(f"Warning: 'features' key not found or not a list in {filename}")

            except FileNotFoundError:
                print(f"Error: File not found: {filepath}")
            except json.JSONDecodeError:
                print(f"Error: Invalid JSON format in {filepath}")
            except Exception as e:
                print(f"An unexpected error occurred while processing {filepath}: {e}")

# Example usage:
input_directory_path = "C:/Users/matthew.ahwal/Documents/capstoneproject-e5-studios/app/src/main/assets/dndclasses"
output_directory_path = "C:/Users/matthew.ahwal/Documents/capstoneproject-e5-studios/app/src/main/assets/features"

extract_and_remove_features(input_directory_path, output_directory_path)