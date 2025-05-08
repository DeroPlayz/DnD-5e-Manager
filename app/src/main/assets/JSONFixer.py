import json
import os

def reformat_json_in_place(filepath):
    """
    Reformats a JSON file to be human-readable with indentation, overwriting the original.

    Args:
        filepath (str): The path to the JSON file to reformat.
    """
    try:
        with open(filepath, 'r') as f:
            data = json.load(f)
    except FileNotFoundError:
        print(f"Error: File not found at '{filepath}'")
        return
    except json.JSONDecodeError:
        print(f"Error: Invalid JSON format in '{filepath}'")
        return

    formatted_json = json.dumps(data, indent=2)

    try:
        with open(filepath, 'w') as outfile:
            outfile.write(formatted_json)
        print(f"Successfully reformatted '{filepath}'")
    except Exception as e:
        print(f"Error writing to file '{filepath}': {e}")

def reformat_directory_inplace(directory_path):
    """
    Recursively loops through all subdirectories and files in the specified directory
    and reformats any JSON files, overwriting the original files (with a backup).

    Args:
        directory_path (str): The path to the directory containing JSON files.
    """
    if not os.path.isdir(directory_path):
        print(f"Error: Directory not found at '{directory_path}'")
        return

    for root, _, files in os.walk(directory_path):
        for filename in files:
            if filename.endswith(".json"):
                filepath = os.path.join(root, filename)
                backup_filepath = filepath + ".bak"
                try:
                    os.rename(filepath, backup_filepath)
                    reformat_json_in_place(backup_filepath)
                    os.rename(backup_filepath, filepath)
                    print(f"Reformatted '{filepath}' (original saved as '{backup_filepath}')")
                except Exception as e:
                    print(f"Error processing '{filepath}': {e}")

if __name__ == "__main__":
    target_path = "C:/Users/matthew.ahwal/Documents/capstoneproject-e5-studios/app/src/main/assets"

    if os.path.isfile(target_path) and target_path.endswith(".json"):
        reformat_json_in_place(target_path)
    elif os.path.isdir(target_path):
        reformat_directory_inplace(target_path)
    else:
        print("Invalid path provided. Please enter a valid JSON file path or directory path.")